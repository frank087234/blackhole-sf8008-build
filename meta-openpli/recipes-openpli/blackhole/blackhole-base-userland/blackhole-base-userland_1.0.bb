SUMMARY = "BlackHole base userland"
DESCRIPTION = "BlackHole base utilities, CAM control, EPG helpers and configuration"
LICENSE = "CLOSED"

SRC_URI = " \
    file://etc \
    file://usr \
"

INSANE_SKIP:${PN} += "license-format file-rdeps arch"

do_install() {
    install -d ${D}

    cp -a ${UNPACKDIR}/etc ${D}/
    cp -a ${UNPACKDIR}/usr ${D}/

    chown -R root:root ${D}/etc ${D}/usr

    chmod 0755 ${D}${bindir}/Blackholecmd
    chmod 0755 ${D}${bindir}/StartBhCam
    chmod 0755 ${D}${bindir}/bhextramod
    chmod 0755 ${D}${bindir}/blackholesocker
    chmod 0755 ${D}${bindir}/getepgchannels
    chmod 0755 ${D}${bindir}/bh-rename-crashlogs
    chmod 0755 ${D}${prefix}/camscript/Ncam_Ci.sh 2>/dev/null || true
}

FILES:${PN} += " \
    ${sysconfdir}/Bhepgproviders.cfg \
    ${sysconfdir}/BhCamConf \
    ${sysconfdir}/bh_plugins.pos \
    ${bindir}/Blackholecmd \
    ${bindir}/StartBhCam \
    ${bindir}/bhextramod \
    ${bindir}/blackholesocker \
    ${bindir}/getepgchannels \
    ${bindir}/bh-rename-crashlogs \
    ${prefix}/camscript/Ncam_Ci.sh \
"
