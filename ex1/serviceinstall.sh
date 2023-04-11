#! /bin/bash


user="vojtechstoklasa"
appname="semvis"

destination=etc/systemd/system/$appname.service;

echo "
Description=uWSGI instance to serve myproject
After=network.target

[Service]
User=$user
Group=www-data
WorkingDirectory=/home/$user/$appname
Environment="PATH=/home/$user/$appname/deployenv/bin"
ExecStart=/home/$user/$appname/deployenv/bin/uwsgi --ini $appname.ini

[Install]
WantedBy=multi-user.target" > $destination
