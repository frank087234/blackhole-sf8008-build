#!/bin/sh
#************************************#
#          Coded  By audi06_19       #
#             EDit by RAED           #       
#************************************#
clear
FINE="==================================================";
echo -e "$FINE";
echo ".....:: PLEASE WAIT ::.....";
######################################################################################
TMP=`mktemp -d`;
cd ${TMP} > /dev/null 2>&1;
#[ -d /etc/openvpn ] || mkdir -p /etc/openvpn > /dev/null;
######################################################################################
vpnbook_base_url=https://www.vpnbook.com
vpnbook_url=${vpnbook_base_url}/freevpn
tesseract_service_url=https://api.ocr.space/parse/image
timestamp=$(date +%s)
output_file=${TMP}/vpnbok_pwd_${timestamp}.json
CLT='/etc/openvpn/vpnbook-client.conf'
PASSUSR='/etc/openvpn/vpnbook-pass.txt'

function validate_url {
    for ((i = 10; i < 30; i++)); do
        if [[ `curl -Is "${vpnbook_base_url}" 2>&1 | grep -E '(HTTP/2 200|HTTP/1.1 200 OK)'` ]]; then
            return 0
        else
            return 1
        fi
    done
}
if ! validate_url ; then
    echo -e "$FINE";
    echo -e ":Server (vpnbook.com) ERORR...";
    echo -e "May your connection block the site URL ...";
    echo -e "You need to active valid vpn first ...";
    echo -e "$FINE";
    exit 1;
else
    echo -e "$FINE";
    echo -e "Your connection FINE ...";
    echo -e "$FINE";
fi

wget -r -np -l 1 -A zip http://www.vpnbook.com/#openvpn --no-check-certificate 2> /dev/null
mv -f www.vpnbook.com/free-openvpn-account/ vpnbook
rm -rf www.vpnbook.com/
cd vpnbook/
#echo "Extracting files" 
sleep 2
# clear
num=$(ls -l | grep ^- | wc -l)
{
for p in `ls | grep "zip" | sed 's/zip*.//g' | sed 's/.*-//g' | tr '.' ' '`; do
  rm -rf $p
  mkdir -p $p
done

echo $(ls | grep "zip" | sed 's/zip*.//g' | sed 's/.*-//g' | tr '.' ' ') > names
sed -i 's/ /\n/g' names
ls | grep ".zip" > zips

for (( i=1; i<$num+1; i++)); do
    unzip -o $(cat zips | head -n $i | tail -1) -d $(cat names | head -n $i | tail -1)
done
} &> /dev/null
#echo  "Extracted Successfully" 
#echo "====================="
rm -rf *.zip
rm -rf VPN*
rm -rf zips
rm -rf names

cd FR1
OVPN=`find . -maxdepth 1 -name "*tcp80*" -print`
echo -e "$FINE";
echo $OVPN
echo -e "$FINE";
mv $OVPN vpnbook-client.conf
sed -i 's#auth-user-pass#auth-user-pass /etc/openvpn/vpnbook-pass.txt\nlog  /etc/openvpn/openvpn.log#g' vpnbook-client.conf

# Retrieve the Password URL from the official webpage
pwd_url=$(curl -s ${vpnbook_url} | grep -m2 "Password:" | tail -n1 | cut -d \" -f2)
#echo "Retrieving Password at the following URL: ${vpnbook_base_url}/${pwd_url}"
curl -X POST --header "apikey: 5a64d478-9c89-43d8-88e3-c65de9999580" \
  -F "url=${vpnbook_base_url}/${pwd_url}" \
  -F 'language=eng' \
  -F 'isOverlayRequired=true' \
  -F 'FileType=.Auto' \
  -F 'IsCreateSearchablePDF=false' \
  -F 'isSearchablePdfHideTextLayer=true' \
  -F 'scale=true' \
  -F 'detectOrientation=false' \
  -F 'isTable=false' \
  -s ${tesseract_service_url} -o ${output_file}

pwd=$(cat ${output_file} \
  | grep -Eo '"WordText":.*?[^\\]",' \
  | awk -F':' '{print $2}' \
  | awk -F',' '{print $1}' \
  | awk '{ gsub(/^[ \t]+|[ \t]+$/, ""); print }' \
  | tr -d \")

rm -f /etc/openvpn/*.conf > /dev/null;
rm -f /etc/openvpn/*.txt > /dev/null;

cp -f vpnbook-client.conf $CLT
echo -e "vpnbook\n${pwd}" > $PASSUSR
echo -e "Retrieved \nUsername:--- vpnbook ---\nPassword:--- ${pwd} ---"

rm -rf $TMP

exit 0;
