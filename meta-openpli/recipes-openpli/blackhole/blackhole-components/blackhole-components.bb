SUMMARY = "BlackHole 13.5 components"
DESCRIPTION = "Genuine BlackHole 13.5 Python components and DeviceManager"
LICENSE = "CLOSED"

SRC_URI = "file://Blackhole \
           file://Components \
           file://Plugins \
           file://Screens \
           file://Tools \
"

INSANE_SKIP:${PN} += "license-format file-rdeps arch"

do_install() {
    install -d ${D}${libdir}/enigma2/python

    cp -a ${UNPACKDIR}/Blackhole ${D}${libdir}/enigma2/python/
    cp -a ${UNPACKDIR}/Components ${D}${libdir}/enigma2/python/
    cp -a ${UNPACKDIR}/Plugins ${D}${libdir}/enigma2/python/
    cp -a ${UNPACKDIR}/Screens ${D}${libdir}/enigma2/python/
    cp -a ${UNPACKDIR}/Tools ${D}${libdir}/enigma2/python/

    chown -R root:root ${D}${libdir}/enigma2/python/Blackhole
    chown -R root:root ${D}${libdir}/enigma2/python/Components
    chown -R root:root ${D}${libdir}/enigma2/python/Plugins
    chown -R root:root ${D}${libdir}/enigma2/python/Screens
    chown -R root:root ${D}${libdir}/enigma2/python/Tools

    chmod 0755 ${D}${libdir}/enigma2/python/Blackhole/DeviceManager/bin/armv7l/exfatfsck
    chmod 0755 ${D}${libdir}/enigma2/python/Blackhole/DeviceManager/bin/armv7l/mkexfatfs
      rm -f ${D}${libdir}/enigma2/python/Components/About.pyc
      rm -f ${D}${libdir}/enigma2/python/Components/Converter/BhAnalogic.pyc
      rm -f ${D}${libdir}/enigma2/python/Components/Converter/BhStreamInfo.pyc
      rm -f ${D}${libdir}/enigma2/python/Components/Renderer/Bhclock.pyc
      rm -f ${D}${libdir}/enigma2/python/Screens/LogManager.pyc
      rm -f ${D}${libdir}/enigma2/python/Tools/StbHardware.pyc
}

FILES:${PN} += "${libdir}/enigma2/python/Blackhole"
FILES:${PN} += "${libdir}/enigma2/python/Components"
FILES:${PN} += "${libdir}/enigma2/python/Plugins"
FILES:${PN} += "${libdir}/enigma2/python/Screens"
FILES:${PN} += "${libdir}/enigma2/python/Tools"
