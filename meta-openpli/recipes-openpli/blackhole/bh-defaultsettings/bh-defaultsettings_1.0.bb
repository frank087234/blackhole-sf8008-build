SUMMARY = "BlackHole default settings"
DESCRIPTION = "Default Enigma2 settings for BlackHole"
LICENSE = "CLOSED"

SRC_URI = "file://settings"


do_install() {
    install -d ${D}${sysconfdir}/enigma2
    install -m 0644 ${UNPACKDIR}/settings ${D}${sysconfdir}/enigma2/settings
}

FILES:${PN} += "${sysconfdir}/enigma2/settings"
