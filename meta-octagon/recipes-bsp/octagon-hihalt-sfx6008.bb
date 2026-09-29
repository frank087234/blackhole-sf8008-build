SUMMARY = "halt for Octagon Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS:${PN} = "harfbuzz"

SRCDATE = "20220305"

PV = "${SRCDATE}"
PR = "r1"

INITSCRIPT_NAME = "suspend"
INITSCRIPT_PARAMS = "start 89 0 ."
inherit update-rc.d

SRC_URI  = "http://downloads.openpli.org/archive/octagon/${MACHINE}-hihalt-${SRCDATE}.tar.gz \
    file://suspend.sh \
    file://standby_leave.sh \
    file://standby_enter.sh \
"

S = "${UNPACKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/hihalt ${D}/${bindir}
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${S}/suspend.sh ${D}${sysconfdir}/init.d/suspend
    install -d ${D}/usr/script
    install -m 0755 ${S}/standby_leave.sh ${D}/usr/script/standby_leave.sh
    install -m 0755 ${S}/standby_enter.sh ${D}/usr/script/standby_enter.sh
}

do_package_qa() {
}

FILES:${PN}  = "${bindir}/hihalt ${sysconfdir}/init.d /usr/script"

SRC_URI[md5sum] = "924c92b27444eb63fae834f8ea20acb6"
SRC_URI[sha256sum] = "789f343a38fb52d0ff18a70a196d553b5712c5a3a7584e010ea88ab20a95f984"
