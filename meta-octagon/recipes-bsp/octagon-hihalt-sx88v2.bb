SUMMARY = "halt for Octagon Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS:${PN} = "harfbuzz"

SRCDATE = "20221203"

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

SRC_URI[md5sum] = "354c323b45bae4ee4f20eb7749685699"
SRC_URI[sha256sum] = "96c864e94af9cdbee28658f23076fd52ee748db4c8b01532eb2b5fe122a7e249"


