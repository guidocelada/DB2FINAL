#!/bin/bash

green='\033[0;32m';
yellow='\033[0;33m';
red='\033[0;31m';
reset='\033[0m';

DATABASE=DB2FINAL
USER=root
HOST=localhost
PASS=

echo -e "${yellow}Recreating schema ...${reset}";
mysql -h $HOST -u $USER $PASS $DATABASE < data.sql
echo -e "${green}DONE${reset}";