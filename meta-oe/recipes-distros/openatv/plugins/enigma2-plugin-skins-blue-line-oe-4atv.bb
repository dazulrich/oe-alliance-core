SUMMARY = "Full HD Skin for ATV Images"
MAINTAINER = "stein17"

require conf/license/license-gplv2.inc

inherit gitpkgv allarch

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
VER="1.0"

RDEPENDS_${PN} = "enigma2-plugin-systemplugins-weathercomponenthandler"

SRC_URI="git://github.com/stein17/Blue-Line-OE-4ATV.git;protocol=git"

FILES_${PN} = "/"



S = "${WORKDIR}/git"

do_compile_append() {
python -O -m compileall ${S}
}

do_install() {
    install -d ${D}/usr/share/enigma2
    cp -rp ${S}/usr ${D}/
    chmod -R a+rX ${D}/usr/share/enigma2/
    cp -rp ${S}/tmp ${D}/
}

pkg_postinst_${PN} () {
#!/bin/sh
if grep -qs 'getMachineBrand=Octagon' cat /tmp/boxbranding.cfg  ; then
	echo "                                 "
	echo "*********************************"
	echo "Octagon Box found!"
	echo "*********************************"
	echo "                                 "
	cp /tmp/octagon/*.png /usr/share/enigma2/Blue-Line-OE-4ATV/menu	
else
	echo "                                 "
	echo "*********************************"
	echo "No Octagon Box found!"
	echo "*********************************"
	echo "                                 "
	cp /tmp/atv/*.png /usr/share/enigma2/Blue-Line-OE-4ATV/menu
fi

echo " Skin Blue-Line-OE-4ATV installed "
exit 0
}

pkg_postrm_${PN} () {
#!/bin/sh
rm -rf /usr/share/enigma2/Blue-Line-OE-4ATV
echo "                                                           "
echo "               ...Skin successful removed.                 "
exit 0
}

pkg_preinst_${PN} () {
#!/bin/sh
python /usr/lib/enigma2/python/BoxBrandingTest.pyo | sed 's/<$//' | sed 's/ /_/g' > /tmp/boxbranding.cfg
echo "        Skin Blue-Line-OE-4ATV will be now installed...            "
exit 0
}

pkg_prerm_${PN} () {
#!/bin/sh
echo "                                                           "
echo "              Skin is now being removed...                 "
echo "                                                           "
exit 0
}

do_package_qa[noexec] = "1"

