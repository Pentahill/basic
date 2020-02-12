FROM ubuntu:18.04

COPY ./jdk-8u231-linux-x64.tar.gz /tmp

# jdk
ENV VERSION 8
ENV UPDATE 181

ENV JAVA_HOME /usr/lib/jvm/java8
ENV JRE_HOME ${JAVA_HOME}/jre
ENV PATH=$JAVA_HOME/bin:$PATH
ENV DEBIAN_FRONTEND noninteractive

RUN cd /tmp && tar -zxvf jdk-8u231-linux-x64.tar.gz && \
    mkdir -p ${JAVA_HOME} && mv /tmp/jdk1.8.0_231/* ${JAVA_HOME} && \
    rm -rf /tmp/*

#RUN apt-get update && apt-get install -y nginx
#ENTRYPOINT ["nginx"]

COPY web/mlp-1.0-SNAPSHOT.jar /tmp
WORKDIR /tmp
ENTRYPOINT['java', '-jar', '/tmp/mlp-1.0-SNAPSHOT.jar']

EXPOSE 80/tcp
EXPOSE 80/udp

#RUN update-alternatives --install "/usr/bin/java" "java" "${JRE_HOME}/bin/java" 1 && \
#    update-alternatives --install "/usr/bin/javac" "javac" "${JAVA_HOME}/bin/javac" 1 && \
#    update-alternatives --set java "${JRE_HOME}/bin/java" && \
#    update-alternatives --set javac "${JAVA_HOME}/bin/javac"
#
## Pick up some TF dependencies
#RUN apt-get update && apt-get install -yq --no-install-recommends \
#        build-essential \
#        curl \
#        libfreetype6-dev \
#        libhdf5-serial-dev \
#        libpng12-dev \
#        libzmq3-dev \
#        pkg-config \
#        python \
#        python-dev \
#        rsync \
#        software-properties-common \
#        unzip \
#        python-tk \
#        libsasl2-dev \
#        vim \
#        net-tools \
#        iputils-ping \
#        net-tools  \
#        gcc \
#        libkrb5-dev  \
#        krb5-user  \
#        telnet  \
#        libsasl2-dev \
#        libsasl2-2 \
#        libsasl2-modules-gssapi-mit   \
#        expect \
#        vim \
#        && \
#    apt-get clean && \
#    rm -rf /var/lib/apt/lists/*
#
#RUN curl -O https://bootstrap.pypa.io/get-pip.py && \
#    python get-pip.py && \
#    rm get-pip.py
#
#RUN pip --no-cache-dir install \
#        Pillow \
#        h5py \
#        ipykernel \
#        jupyter \
#        matplotlib \
#        numpy \
#        pandas \
#        scipy \
#        sklearn \
#	    hdfs \
#	    seaborn \
#	    tornado \
#	    sasl \
#        thrift \
#        pyhive \
#        thrift_sasl \
#        pyspark \
#        pyhive \
#        thrift \
#        pywinrm  \
#        thrift_sasl  \
#        sasl  \
#        requests \
#        requests-kerberos  \
#        && \
#    python -m ipykernel.kernelspec
#
## Install TensorFlow CPU version from central repo
#RUN pip --no-cache-dir install \
#	    https://files.pythonhosted.org/packages/40/73/010fe27e6544515909e959a54e49f4d2d34d829291a3b64ba2525d00db1f/tensorflow-1.10.0-cp27-cp27mu-manylinux1_x86_64.whl
#	    # https://storage.googleapis.com/tensorflow/linux/cpu/tensorflow-0.5.0-cp27-none-linux_x86_64.whl
#
## --- ~ DO NOT EDIT OR DELETE BETWEEN THE LINES --- #
#
#
#
#
##add kerberos
#COPY krb5.conf /etc/krb5.conf
#COPY kinit.sh /
#
##RUN klist
#
#RUN chmod 755 ./kinit.sh
#
#
#
## TensorBoard
#EXPOSE 6006
#
## spark application
#EXPOSE 4040
#
## computing service
#EXPOSE 8889
#ARG CACHEBUST=1
#
#COPY  ./python_mlp /python_mlp
#
#CMD ["/bin/bash","./kinit.sh"]