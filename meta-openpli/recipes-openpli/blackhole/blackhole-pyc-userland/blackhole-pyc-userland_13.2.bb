SUMMARY = "BlackHole 13.2 Python userland and Universe support"
DESCRIPTION = "BlackHole 13.2 Python components, Universe/RedPanel support, bootlogos and spinners"
LICENSE = "LicenseRef-blackhole-pyc-userland-CLOSED"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4666182df6d1cafff85864902ad66765"
NO_GENERIC_LICENSE[blackhole-pyc-userland-CLOSED] = "LICENSE"

SRC_URI = "file://usr file://etc file://LICENSE"
S = "${UNPACKDIR}"


INSANE_SKIP:${PN} += "license-format file-rdeps arch"

do_install() {
    install -d ${D}
    cp -a ${UNPACKDIR}/usr ${D}/
    cp -a ${UNPACKDIR}/etc ${D}/
    chown -R root:root ${D}/usr ${D}/etc
}

FILES:${PN} += "/usr /etc"
