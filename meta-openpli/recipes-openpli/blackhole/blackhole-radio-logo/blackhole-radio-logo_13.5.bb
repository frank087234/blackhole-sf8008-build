SUMMARY = "BlackHole 13.5 radio logo"
DESCRIPTION = "BlackHole radio logo from BlackHole 13.5"
LICENSE = "CLOSED"
INSANE_SKIP:${PN} += "license-format"

SRC_URI = "file://usr/share/blackhole-radio-logo/radio.mvi"


do_install() {
    install -d ${D}${datadir}/blackhole-radio-logo
    install -m 0644 ${UNPACKDIR}/usr/share/blackhole-radio-logo/radio.mvi \
        ${D}${datadir}/blackhole-radio-logo/radio.mvi
}

FILES:${PN} += "${datadir}/blackhole-radio-logo/radio.mvi"
