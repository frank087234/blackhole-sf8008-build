SUMMARY = "libreader for Octagon Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS:${PN} = "libsdl"

COMPATIBLE_MACHINE = "sfx6008"

SRCDATE = "20221111"

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

SRC_URI[md5sum] = "98c3574db4b0c5c5a2aeb283293b718d"
SRC_URI[sha256sum] = "a12db5cfea63c9745c1e01874e84fe1c0acceb6454e63720f4f7c1a952898c3c"
