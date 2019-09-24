# Android Clean Arch MVP

A basic demonstration of Clean Architecture and MVP pattern based project structure.

Clean Architecture
-----------------
Clean Architecture was introduced by Uncle Bob a few years ago and has grown popular in the Android world too. Clean architecture is a software design philosophy that separates the elements of a design into ring levels. The main rule of clean architecture is that code dependencies can only come from the outer levels inward. Code on the inner layers can have no knowledge of functions on the outer layers. The variables, functions and classes (any entities) that exist in the outer layers can not be mentioned in the more inward levels. It is recommended that data formats also stay separate between levels.

Clean Architecture Layers
-------------------------

![](https://github.com/devendroid/X-Data/blob/master/Android-CleanArch-MVP/layers.png)


Clean Architecture Flow
-----------------------
![](https://github.com/devendroid/X-Data/blob/master/Android-CleanArch-MVP/flow.png)




Clean Architecture Layers by Module
------------------------------------
![](https://github.com/devendroid/X-Data/blob/master/Android-CleanArch-MVP/layers-by-module.png)



Clean Architecture Layers by Module or Package
------------------------------------------------
![](https://github.com/devendroid/X-Data/blob/master/Android-CleanArch-MVP/layers-by-types.png)

License
--------

    Copyright 2019 Deven Singh

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.