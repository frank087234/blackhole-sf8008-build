# rtl8192cufw_TMSC.bin is provided by firmware-rtl8xxxu (SF8008 uses rtl8xxxu driver).
# Make this package empty but keep it in the graph for the 3 driver plugins that RDEPEND on it.

do_install[noexec] = "1"
ALLOW_EMPTY:${PN} = "1"
FILES:${PN} = ""
