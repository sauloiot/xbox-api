#!/bin/bash
YELLOW="\e[1;33m"
MAGENTA="\e[1;36m"
RED="\e[1;31m"
NC="\033[0m"

IMAGENAME=xbox-api
IMAGEVERSION=v1
NETWORK=ms-ghost

echo -n "Type GMAIL user: "
read VGMAIL_USER
if [ -z "$VGMAIL_USER" ]; then
        echo "GMAIL user is required";
        exit;
fi
echo -n "Type GMAIL pass to user $VGMAIL_USER: "
read GMAIL_PASS
if [ -z "$GMAIL_PASS" ]; then
        echo "GMAIL pass is required";
        exit;
fi

echo $RED==== $YELLOW "STEP 1°"$MAGENTA removing containers by image: $IMAGENAME:$IMAGEVERSION $RED====$NC
docker ps -a | awk '{ print $1,$2 }' | grep $IMAGENAME:$IMAGEVERSION | awk '{print $1 }' | xargs -I {} docker stop {} | xargs -I {} docker rm {}

echo $RED==== $YELLOW "STEP 2°"$MAGENTA removing image $IMAGENAME:$IMAGEVERSION $RED====$NC
docker image rm $IMAGENAME:$IMAGEVERSION

echo $RED==== $YELLOW "STEP 3°"$MAGENTA compiling $IMAGENAME with version: $IMAGEVERSION $RED====$NC
./mvnw clean package -DskipTests

echo $RED==== $YELLOW "STEP 4°"$MAGENTA building image $IMAGENAME:$IMAGEVERSION $RED====$NC
docker build -t $IMAGENAME:$IMAGEVERSION .

echo $RED==== $YELLOW "STEP 5°"$MAGENTA starting container by image: $IMAGENAME:$IMAGEVERSION $RED====$NC
docker run --restart unless-stopped -d -p 8080:8080 --name $IMAGENAME --network $NETWORK -e GMAIL_USER=$VGMAIL_USER -e GMAIL_PASS=$GMAIL_PASS $IMAGENAME:$IMAGEVERSION

#unset creds
GMAIL_PASS=""
VGMAIL_PASS=""
GMAIL_USER=""
VGMAIL_USER=""
