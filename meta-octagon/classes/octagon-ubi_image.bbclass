inherit image_types

IMAGE_TYPEDEP:octagonubi = "ubi"

do_image_octagonubi[depends] = " \
    parted-native:do_populate_sysroot \
    dosfstools-native:do_populate_sysroot \
    mtools-native:do_populate_sysroot \
    virtual/kernel:do_populate_sysroot \
    octagon-buildimage-native:do_populate_sysroot \
    "

IMAGE_CMD:octagonubi () {
}