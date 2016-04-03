DESCRIPTION = "Enigma2 plugin to launch and play media from Kodi"
AUTHOR = "Maroš Ondrášek <mx3ldev@gmail.com>"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
PR = "r1"

DEPENDS += "enigma2 virtual/kodi"
RDEPENDS_${PN} += "virtual/kodi"

RRECOMMENDS_${PN} = "enigma2-plugin-extensions-subssupport"

SRCREV = "d52bf6c974668aff098b472b20e0bd4b14b8e717"
SRC_URI = "git://github.com/mx3L/kodiext;protocol=git;branch=master \
    file://videomode.patch"

S = "${WORKDIR}/git"

FILES_${PN} = "${libdir}/enigma2/python/Plugins/Extensions/Kodi \
    ${bindir}/kodiext"

inherit autotools