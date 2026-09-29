SUMMARY = "libreader for Octagon Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS:${PN} = "libsdl"

COMPATIBLE_MACHINE = "sf8008m"

SRCDATE = "20200703"

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

SRC_URI[md5sum] = "97a6489e3a6d88dd3f3254bd0381f348"
SRC_URI[sha256sum] = "7bbfa47749f4a0d17e8c2172d1dd7e0f0d669b69d3722f614738157d64b46fc7"
