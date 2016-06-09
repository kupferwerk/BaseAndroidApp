# Release Checklist Android

## Project Name
#### Person who is responsible for the release

## General
| Task | Done | Comment |
|---|---|---|
|Update GIT|||
|Refresh project|||
|Clean project|||

## Manifest

| Task | Input | Comment / Reason |
|---|---|---|
|Install location auto [on/off] Why?|||
|Previous versionCode|||
|Previous versionName|||
|Release versionCode|||
|Release versionName|||
|App name|||
|Application Id (Package Name)|||
|Check application id with client (visible in PlayStore)|||
|compileSdkVersion|||
|buildToolsVersion|||
|minSdkVersion|||
|targetSdkVersion|||

__List of market place filters:__

* ...
* ...
* ...
* ...
* ...

## Code
| Task | Input | Comment |
|---|---|---|
|Set targetSdkVersion to minSdkVersion. <br> Check if errors only occur where <br> API checks are present.|||
|Reset targetSdkVersion|||
|Remove all Log.* calls|||
|Set shoulddebug = false (only if using KW lib)|||

## App Config
List of all used production urls!

* ...
* ...
* ...
* ...
* ...

## Push

| Task | Input | Comment |
|---|---|---|
|Does the app use push?|||
|GCM ID|||
|Push provider|||
|Push ID|||

## Licensing

| Task | Input | Comment |
|---|---|---|
|Does the app use Licensing?|||
|If yes, is it activated?|||

## Signing

| Task | Input | Comment |
|---|---|---|
|Who does the app signing? [Client/KW/BL]|||
|Used keystore file|||
|Used key|||
|Where is the keystore file hosted?|||

## Facebook

| Task | Input | Comment |
|---|---|---|
|Does the app use Facebook?|||
|Signing certificate uploaded to Facebook?|||

## Google Maps
| Task | Input | Comment |
|---|---|---|
|Does the app use Google Maps?|||
|Google Maps Version|||
|Signing certificate uploaded to Google Maps?|||
|Google Account|||
|Google Map Key|||

## Tracking

List of all tracking frameworks and ID

* __Framework:__ _ID_
* __Framework:__ _ID_
* __Framework:__ _ID_

## Proguard

| Task | Input | Comment |
|---|---|---|
|Does the app use proguard?|||
|Save proguard files|||

## Crash Reporting

| Task | Input | Comment |
|---|---|---|
|Crash reporting tool|||
|Crash reporting ID|||
|Upload proguard mapping|||

## Dependencies

Only needed for dependencies that are not clearly visible and understandable from the gradle files.

| Dependency | Version | Comment |
|---|---|---|
|...|x.x.x||
|...|x.x.x||
|...|x.x.x||

## Permissions

| Permission | New | Reason |
|---|---|---|
|...|x.x.x||
|...|x.x.x||
|...|x.x.x||

| Task | Done |
|---|---|
|Checked if permissions changed in the release apk||

## Git

| ToDo | Input | Comment |
|---|---|---|
|Release Commit Hash|||
|Tag release commit with version name|||
|Push to origin (with tags)|||
|Merge dev/hotfix in master|||
|Delete finished branches|||

## APK ToDos

| Task | Done | Location |
|---|---|---|
|save signed apk file|||
|save unsigned apk apk file|||
|save debug apk file|||
|create a rollback apk ||| 

## Release Checklist

| Task | Done | Location |
|---|---|---|
|save this file|||
|save this file as PDF|||
