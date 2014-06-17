LayoutInspector
===============

Search all duplicates data in Android layout xml files.

Example
=======
```xml
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context="com.example.layouttest.MainActivity"
    android:id="@+id/container"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">
        <RelativeLayout 
            android:layout_width="match_parent"
            android:layout_height="wrap_content">
            <Button
                android:id="@+id/find"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_alignParentRight="true"
                android:text="Rechercher" />
            <EditText
                android:layout_width="wrap_content"
                android:layout_height="match_parent"
                android:layout_alignParentLeft="true"
                android:layout_toLeftOf="@+id/find"
                android:layout_centerVertical="true"
                android:inputType="text"/>
        </RelativeLayout>
        <TextView 
            android:text="Une option : "
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textColor="#FF0000"
            android:gravity="center_horizontal"/>
        <RadioGroup 
            android:layout_height="wrap_content"
            android:layout_width="match_parent"
            android:orientation="horizontal">
            <RadioButton 
                android:text="Oui"
                android:layout_height="wrap_content"
                android:layout_width="0dp"
                android:layout_weight="0.5"/>
            <RadioButton 
                android:text="Non"
                android:layout_height="wrap_content"
                android:layout_width="0dp"
                android:layout_weight="0.5"/>
           </RadioGroup>
        <TextView 
            android:text="Une autre option : "
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textColor="#FF0000"
            android:gravity="center_horizontal"/>
        <RadioGroup 
            android:layout_height="wrap_content"
            android:layout_width="match_parent"
            android:orientation="horizontal">
            <RadioButton 
                android:text="Oui"
                android:layout_height="wrap_content"
                android:layout_width="0dp"
                android:layout_weight="0.5"/>
            <RadioButton 
                android:text="Non"
                android:layout_height="wrap_content"
                android:layout_width="0dp"
                android:layout_weight="0.5"/>
           </RadioGroup>
           <LinearLayout
               android:layout_width="match_parent"
               android:layout_height="wrap_content"
               android:orientation="horizontal">
            <TextView 
                   android:text="Un label : "
                   android:layout_width="0dp"
                   android:layout_weight="0.33"
                   android:layout_height="wrap_content"/>
            <Spinner 
                android:id="@+id/spinner"
                android:layout_width="0dp"
                android:layout_weight="0.66"
                android:layout_height="wrap_content"/>
        </LinearLayout>
           <LinearLayout
               android:layout_width="match_parent"
               android:layout_height="wrap_content"
               android:orientation="horizontal">
            <TextView 
                   android:text="Un label : "
                   android:layout_width="0dp"
                   android:layout_weight="0.33"
                   android:layout_height="wrap_content"/>
            <EditText
                android:text="A remplir"
                android:layout_width="0dp"
                android:layout_weight="0.66"
                android:layout_height="wrap_content"/>
        </LinearLayout>
           <LinearLayout
               android:layout_width="match_parent"
               android:layout_height="wrap_content"
               android:gravity="center_horizontal"
               android:orientation="horizontal">
            <ImageView 
                android:background="@drawable/ic_launcher"
                android:layout_width="128dip"
                android:layout_height="128dip"
                android:scaleType="fitCenter"/>
            <ImageView 
                android:background="@drawable/ic_launcher"
                android:layout_width="128dip"
                android:layout_height="128dip"
                android:scaleType="fitCenter"/>
            <ImageView 
                android:background="@drawable/ic_launcher"
                android:layout_width="128dip"
                android:layout_height="128dip"
                android:scaleType="fitCenter"/>
        </LinearLayout>
        <LinearLayout
               android:layout_width="match_parent"
               android:layout_height="wrap_content"
               android:orientation="horizontal">
               <Button
                   android:text="Bouton 1"
                   android:layout_width="0dp"
                   android:layout_weight="0.33"
                   android:layout_height="wrap_content"/>
               <Button
                   android:text="Bouton 2"
                   android:layout_width="0dp"
                   android:layout_weight="0.33"
                   android:layout_height="wrap_content"/>
               <Button
                   android:text="Bouton 3"
                   android:layout_width="0dp"
                   android:layout_weight="0.33"
                   android:layout_height="wrap_content"/>
           </LinearLayout>
    </LinearLayout>
</ScrollView>
```

Result with command ```java -jar LayoutInspector.jar``` : 

```
Occurence : 3
Group of attributes : 
	android:background="@drawable/ic_launcher"
	android:layout_height="128dip"
	android:layout_width="128dip"
	android:scaleType="fitCenter"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:gravity="center_horizontal"
	android:layout_height="wrap_content"
	android:layout_width="match_parent"
	android:textColor="#FF0000"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_weight="0.5"
	android:layout_width="0dp"
	android:text="Oui"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_weight="0.5"
	android:layout_width="0dp"
	android:text="Non"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_weight="0.33"
	android:layout_width="0dp"
	android:text="Un label : "
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 6
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_width="match_parent"
	android:orientation="horizontal"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 5
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_weight="0.33"
	android:layout_width="0dp"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 4
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_weight="0.5"
	android:layout_width="0dp"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 3
Group of attributes : 
	android:gravity="center_horizontal"
	android:layout_height="wrap_content"
	android:layout_width="match_parent"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 3
Group of attributes : 
	android:background="@drawable/ic_launcher"
	android:layout_height="128dip"
	android:layout_width="128dip"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 3
Group of attributes : 
	android:background="@drawable/ic_launcher"
	android:layout_height="128dip"
	android:scaleType="fitCenter"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 3
Group of attributes : 
	android:background="@drawable/ic_launcher"
	android:layout_width="128dip"
	android:scaleType="fitCenter"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 3
Group of attributes : 
	android:layout_height="128dip"
	android:layout_width="128dip"
	android:scaleType="fitCenter"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:gravity="center_horizontal"
	android:layout_height="wrap_content"
	android:textColor="#FF0000"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:gravity="center_horizontal"
	android:layout_width="match_parent"
	android:textColor="#FF0000"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_width="match_parent"
	android:textColor="#FF0000"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_weight="0.5"
	android:text="Oui"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_width="0dp"
	android:text="Oui"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_weight="0.5"
	android:layout_width="0dp"
	android:text="Oui"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_weight="0.5"
	android:text="Non"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_width="0dp"
	android:text="Non"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_weight="0.5"
	android:layout_width="0dp"
	android:text="Non"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_weight="0.33"
	android:text="Un label : "
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_width="0dp"
	android:text="Un label : "
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_weight="0.33"
	android:layout_width="0dp"
	android:text="Un label : "
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_weight="0.66"
	android:layout_width="0dp"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 11
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_width="0dp"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 10
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_width="match_parent"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 6
Group of attributes : 
	android:layout_height="wrap_content"
	android:orientation="horizontal"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 6
Group of attributes : 
	android:layout_width="match_parent"
	android:orientation="horizontal"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 5
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_weight="0.33"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 5
Group of attributes : 
	android:layout_weight="0.33"
	android:layout_width="0dp"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 4
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_weight="0.5"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 4
Group of attributes : 
	android:layout_weight="0.5"
	android:layout_width="0dp"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 3
Group of attributes : 
	android:gravity="center_horizontal"
	android:layout_height="wrap_content"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 3
Group of attributes : 
	android:gravity="center_horizontal"
	android:layout_width="match_parent"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 3
Group of attributes : 
	android:background="@drawable/ic_launcher"
	android:layout_height="128dip"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 3
Group of attributes : 
	android:background="@drawable/ic_launcher"
	android:layout_width="128dip"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 3
Group of attributes : 
	android:background="@drawable/ic_launcher"
	android:scaleType="fitCenter"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 3
Group of attributes : 
	android:layout_height="128dip"
	android:layout_width="128dip"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 3
Group of attributes : 
	android:layout_height="128dip"
	android:scaleType="fitCenter"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 3
Group of attributes : 
	android:layout_width="128dip"
	android:scaleType="fitCenter"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:gravity="center_horizontal"
	android:textColor="#FF0000"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_height="wrap_content"
	android:textColor="#FF0000"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_width="match_parent"
	android:textColor="#FF0000"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_height="wrap_content"
	android:text="Oui"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_weight="0.5"
	android:text="Oui"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_width="0dp"
	android:text="Oui"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_height="wrap_content"
	android:text="Non"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_weight="0.5"
	android:text="Non"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_width="0dp"
	android:text="Non"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_height="wrap_content"
	android:text="Un label : "
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_weight="0.33"
	android:text="Un label : "
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_width="0dp"
	android:text="Un label : "
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_height="wrap_content"
	android:layout_weight="0.66"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml

Occurence : 2
Group of attributes : 
	android:layout_weight="0.66"
	android:layout_width="0dp"
Concerned files : 
	/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx/activity_main.xml
```

Licence
=======

BSD

All rights reserved.
Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
1. Redistributions of source code must retain the above copyright notice, this
list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright notice, 
this list of conditions and the followingdisclaimer in the documentation and/or
other materials provided with the distribution.
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE 
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE 
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR 
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER 
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, 
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE 
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
