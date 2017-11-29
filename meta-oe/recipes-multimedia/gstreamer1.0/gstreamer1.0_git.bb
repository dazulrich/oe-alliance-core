DEFAULT_PREFERENCE = "-1"

include gstreamer1.0.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6762ed442b3822387a51c92d928ead0d \
                    file://gst/gst.h;beginline=1;endline=21;md5=e059138481205ee2c6fc1c079c016d0d \
                    "


UPSTREAM_CHECK_GITTAGREGEX = "(?P<pver>(\d+(\.\d+)+))"

SRCREV_base = "f649f0a44f42fda56c8eb912b7ffca0f1178b905"
SRCREV_common = "3f4aa969cbe39584a649d98d4cf321d78bd73092"
SRCREV_FORMAT = "base"

SRC_URI = "git://anongit.freedesktop.org/gstreamer/gstreamer;branch=master;name=base \
		   git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
"

SRC_URI += "file://0001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
			file://0001-revert-use-new-gst-adapter-get-buffer.patch"

S = "${WORKDIR}/git"

GST_VERSION_FULL ="1.13.0.2"
inherit gitpkgv
PV = "${GST_VERSION_FULL}+git${SRCPV}"
PKGV = "${GST_VERSION_FULL}+git${GITPKGV}"


do_configure_prepend() {
	${S}/autogen.sh --noconfigure
}

