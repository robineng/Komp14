#! /bin/sh

CURRDIR=pwd
mv .git ~/.git

./tigrissubmit ~/Komp14/

mv ~/.git $CURRDIR
