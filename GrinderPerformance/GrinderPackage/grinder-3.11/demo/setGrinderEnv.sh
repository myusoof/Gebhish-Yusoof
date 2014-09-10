#!/usr/bin/ksh
GRINDERPATH=/home/yusoof/projects/o2/Gebhish-Yusoof/GrinderPerformance/GrinderPackage/grinder-3.11
GRINDERPROPERTIES=$GRINDERPATH/demo/grinder.properties
CLASSPATH=$GRINDERPATH/lib/grinder.jar:$GRINDERPATH/lib/jython.jar:$CLASSPATH
export CLASSPATH PATH GRINDERPROPERTIES
