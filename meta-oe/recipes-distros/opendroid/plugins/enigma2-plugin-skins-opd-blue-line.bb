SUMMARY = "Skin Full HD for openDroid Images"
MAINTAINER = "stein17"

require conf/license/license-gplv2.inc

inherit gitpkgv allarch
SRCREV = "${AUTOREV}"
PV = "1.3+git${SRCPV}"
PKGV = "1.3+git${GITPKGV}"
VER="1.3"
PR = "r1"

SRC_URI="git://github.com/stein17/OPD-Blue-Line.git;protocol=git"
FILES_${PN} = "/usr/*"

S = "${WORKDIR}/git"

do_compile_append() {
python -O -m compileall ${S}
}

do_install() {
    install -d ${D}/usr/share/enigma2
    cp -rp ${S}/usr ${D}/
    chmod -R a+rX ${D}/usr/share/enigma2/
}
pkg_postinst_${PN} () {
#!/bin/sh
echo "              ...Skin successful installed.                "
exit 0
}
pkg_postrm_${PN} () {
#!/bin/sh
rm -rf /usr/share/enigma2/OPD_Blue_Line
echo "                                                           "
echo "               ...Skin successful removed.                 "
exit 0
}
pkg_preinst_${PN} () {
#!/bin/sh
echo "        OPD-Blue-Line Skin will be now installed...            "
exit 0
}
pkg_prerm_${PN} () {
#!/bin/sh
echo "                                                           "
echo "              OPD-Blue-Line is now being removed...          "
echo "                                                           "
exit 0
}
do_package_qa[noexec] = "1"
