SUMMARY = "BlackHole 13.5 startup logo"
DESCRIPTION = "BlackHole startup logo from BlackHole 13.5"
LICENSE = "CLOSED"
INSANE_SKIP:${PN} += "license-format"

SRC_URI = "file://usr/share/blackhole-startup-logo/startup.mvi"


do_install() {
    install -d ${D}${datadir}/blackhole-startup-logo
    install -m 0644 ${UNPACKDIR}/usr/share/blackhole-startup-logo/startup.mvi \
        ${D}${datadir}/blackhole-startup-logo/startup.mvi
}

FILES:${PN} += "${datadir}/blackhole-startup-logo/startup.mvi"
