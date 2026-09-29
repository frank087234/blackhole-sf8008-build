# Remove RDEPENDS on packages we BBMASK'd (not buildable for SF8008)
RDEPENDS:${PN}:remove = "enigma2-locale-meta enigma2-plugin-systemplugins-transcodingsettings"
