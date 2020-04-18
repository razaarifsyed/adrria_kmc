# adrria_kmc

This is an Android App I developed in 2019 to be used for reporting Adverse Drug Reaction by the Kasturba Hospital Manipal. It was a part of my final year's student project.

Its not published on the playstore, for security reasons. 

However you can view a sample video of the app at the link below. Here the video shows an older version of the app, when the app was still in draft stage. 
https://drive.google.com/open?id=1-7BhBwIobya4guK7H0tOi6IDqUD9Prqh

The app was developed in Java through Android Studio, and firebase is used for realtime database and authentication service.

-------------
Notes:

For security reasons, I created a separate copy of my orignal app. And i haven't added or linked this project to firebase. So please create your own firebase project, for this to work.
Add firebase realtime database and authentication service(enable email authentication too). 
I have added an image "tree.jpeg" file just to show you my firebase realtime database structure. 

After setting up firebase, if you run the project. It wont work properly. Activities will vanish as soon as you open them.
You will have to modify the layouts in the project wherever an activity uses constraint layout. Its because i used an older version of constraint layout code which is no longer supported. To correct this flaw, please modify the xml files. The starting and the ending tags.

Replace wherever you see 
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android" 

to

<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"

And replace
</android.support.constraint.ConstraintLayout>

to

</androidx.constraintlayout.widget.ConstraintLayout>

Just lookout for constraint layout in the project, in case more modifications are needed.

--------

Let me know if you need any help or found this useful :)


