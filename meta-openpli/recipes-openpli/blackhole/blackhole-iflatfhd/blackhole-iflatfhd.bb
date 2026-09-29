SUMMARY = "BlackHole iFlatFHD skin"
DESCRIPTION = "iFlatFHD skin from BlackHole 13.5"
LICENSE = "CLOSED"

SRC_URI = "file://iFlatFHD"

INSANE_SKIP:${PN} += "license-format"

do_install() {
    install -d ${D}${datadir}/enigma2
    cp -a ${UNPACKDIR}/iFlatFHD ${D}${datadir}/enigma2/
    chown -R root:root ${D}${datadir}/enigma2/iFlatFHD
}

FILES:${PN} += "${datadir}/enigma2/iFlatFHD"
