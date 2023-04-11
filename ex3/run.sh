g++ -std=c++14 main.cpp && echo "compiled" 
x=0
while [ $x -le $1 ]
do
	  x=$[$x+1]
 		./a.out < 'test'$x'.txt'
		echo "REF:"
		cat 'test'$x'.txt'
done
