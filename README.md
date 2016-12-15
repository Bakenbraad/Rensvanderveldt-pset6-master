# Rensvanderveldt-pset6

This app allows a user to register and log in to their personalized emergency service responds.
The user can add emergency service areas such as Kennemerland, Limburg-Zuid, etc. to their 
personal settings in the main settings menu.

The selected regions' data will be requested from alarmeringen.nl as an rss feed and the titles are parsed
to the main listview. The refresh button allows the user to do another asynctask request to pull new emergency
responds. The logout button makes the system forget the current user and sends them to the Login screen.
The user may be remembered between sessions and reauthenticated on re-entry by means of sharedpreferences.
They may chose to be remembered through a "remember me" checkbox on login and register screen.
Registering also adds a user (upon entering a valid name and 2 identical passwords) to the database
and loggs them in at the same time. Firebase is used to carry user information between devices and
makes this application multiapplicable.

The following tutorials were used in the making of this app:
http://www.mysamplecode.com/2012/07/android-listview-checkbox-example.html
https://www.youtube.com/watch?v=19NSla4FNdQ
https://firebase.google.com/docs/auth/
