#!/bin/bash
FAILED=0
cd ./SimpleCalcTest
ant clean debug install test
if [ "$?" = 1 ]; then
	echo "SimpleCalcTest build failed!"
    FAILED=1
fi
cd ..

cd ./SimpleCalc
ant debug install
if [ "$?" = 1 ]; then
    echo "SimpleCalc build failed!"
    FAILED=1
fi
cd ..

exit $FAILED
