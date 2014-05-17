#!/bin/bash

green='\033[0;32m';
yellow='\033[0;33m';
red='\033[0;31m';
reset='\033[0m';

DATABASE=DB2FINAL
USER=root
HOST=localhost
PASS=

echo -e "${yellow}Recreating database...${reset}";
mysql -h $HOST -u $USER $PASS $DATABASE < database.sql

echo -e "${green}Done!${reset}";