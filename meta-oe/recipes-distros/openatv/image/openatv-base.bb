SUMMARY = "Base packages require for image."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

ALLOW_EMPTY_${PN} = "1"

PV = "1.0"
PR = "r29"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = "\
    bash \
    ca-certificates \
    virtual/cron \
    flip \
    hddtemp \
    oe-alliance-base \
    openatv-bootlogo \
    openatv-enigma2 \
    openatv-spinner \
    openssh-sftp-server \
    packagegroup-base-smbfs-client \
    python-imaging \
    python-service-identity \
    rtmpdump \
    ${@bb.utils.contains("TUNE_FEATURES", "armv", "glibc-compat", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "dreamboxv1", "", "ofgwrite", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", " \
        iproute2 \
        ntfs-3g \
    ", d)} \
    "
