SUMMARY = "grab for Octagon Chipset ${SOC_FAMILY}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "sfx6008"

SRCDATE = "20221022"

PV = "${SRCDATE}"
PR = "r0"

RPROVIDES:${PN}  = "aio-grab"
RREPLACES:${PN}  = "aio-grab"
RCONFLICTS:${PN} = "aio-grab"

SRC_URI = "http://downloads.openpli.org/archive/octagon/${SOC_FAMILY}-grab-${SRCDATE}.tar.gz"

S = "${UNPACKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/grab ${D}/${bindir}
}

do_package_qa() {
}

FILES:${PN}  = "${bindir}/grab"

SRC_URI[md5sum] = "f17956cfe7abf13bf73df69ea3d344f7"
SRC_URI[sha256sum] = "7aa36a4d75785efb969d0272b7949ba9b057ab014dfbb1c9fa658f7ecfde2cf9"
