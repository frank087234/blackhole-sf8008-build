SUMMARY = "libreader for Octagon Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS:${PN} = "libsdl"

COMPATIBLE_MACHINE = "sf8008"

SRCDATE = "20200612"

PV = "${SRCDATE}"
PR = "r0"

SRC_URI = "http://downloads.openpli.org/archive/octagon/${MACHINE}-libreader-${SRCDATE}.tar.gz"

S = "${UNPACKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/libreader ${D}/${bindir}
}

do_package_qa() {
}

FILES:${PN}  = "${bindir}/libreader"

SRC_URI[md5sum] = "9a036c2638709842956a65350769c335"
SRC_URI[sha256sum] = "29728c136ccc8a170054f0e4ea8b6ce4dfa35f58d0c9970c84e8c1e72aa9a110"
