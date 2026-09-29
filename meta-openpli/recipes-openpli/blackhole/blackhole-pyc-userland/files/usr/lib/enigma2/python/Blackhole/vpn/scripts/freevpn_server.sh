#!/bin/sh
#************************************#
#          Coded  By YASSINOV        #
#             EDit by RAED           #       
#************************************#
clear
FINE="==================================================";
echo -e "$FINE";
echo ".....:: PLEASE WAIT ::.....";
URL="https://freevpn.me/accounts"
CLT='/etc/openvpn/freevpn-client.conf'
PASSUSR='/etc/openvpn/freevpn-pass.txt'
####################
function validate_url {
    for ((i = 10; i < 30; i++)); do
        if [[ `curl -Is "${URL}" 2>&1 | grep -E '(HTTP/2 200|HTTP/1.1 200 OK)'` ]]; then
            return 0
        else
            return 1
        fi
    done
}
if ! validate_url ; then
    echo -e "$FINE";
    echo -e ":Server (freevpn.me) ERORR...";
    echo -e "May your connection block the site URL ...";
    echo -e "You need to active valid vpn first ...";
    echo -e "$FINE";
    exit 1;
else
    echo -e "$FINE";
    echo -e "Your connection FINE ...";
    echo -e "$FINE";
fi
####################
usr=`wget -q -O- "${URL}/#" | awk -F "server1.freevpn.me" '{print $2}' | sed -ne 's#.*Username:</b> \([^<]*\).*#\1#p' | sed 's/Â.//'`
pwd=`wget -q -O- "${URL}/#" | awk -F "server1.freevpn.me" '{print $2}' | sed -ne 's#.*Password:</b> \([^<]*\).*#\1#p'`
####################
DTMP=`mktemp -d`
cd $DTMP
####################
wget -q -O- ${URL}/ | sed -ne 's#.*href="\([^$<]*\)"><span.*#\1#p' > "vph"
wget -q -O 'vpn.zip' "$(<vph)"
####################
#/etc/init.d/openvpn stop > /dev/null 2>&1
####################
find . -type f -name "vpn.zip" -exec unzip {} + > /dev/null 2>&1
cd *FreeVPN*
cd *NL*
OVPN=`find . -maxdepth 1 -name "*TCP443*" -print`
echo -e "$FINE";
echo $OVPN
echo -e "$FINE";
mv $OVPN freevpn-client.conf
sed -i 's#auth-user-pass#auth-user-pass /etc/openvpn/freevpn-pass.txt\nlog  /etc/openvpn/openvpn.log#g' freevpn-client.conf
####################
rm -f /etc/openvpn/*.conf > /dev/null;
rm -f /etc/openvpn/*.txt > /dev/null;
echo -e ${usr} > $PASSUSR
echo -e ${pwd} >> $PASSUSR
cp -f freevpn-client.conf $CLT
####################
echo -e "Retrieved \nUsername:--- ${usr} ---\nPassword:--- ${pwd} ---"
####################
#echo "Current IP: `wget -qO- http://ip.42.pl/raw%60;echo`"
#/etc/init.d/openvpn start > /dev/null 2>&1
#sleep 8
#echo "New IP    : `wget -qO- http://ip.42.pl/raw%60;echo`"

rm -rf $DTMP

exit 0
