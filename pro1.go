package main

import (
//    "bufio"
    "fmt"
//    "io"
//    "io/ioutil"
    "os"
    )

func check(e error){
	if e != nil{
		panic(e)
	}
}


func main(){
	input := open()
	outArr := parse(input)
	write(outArr)
}

func open() *os.File{

	input, err := os.Open("goput.txt")

        check(err)

	return input
}

func parse(input *os.File) []byte{
	finput, err := input.Stat()
	check(err)
	arr1 := make([]byte, finput.Size())
	outArr := make([]byte, finput.Size())
	_, err = input.Read(arr1)
	check(err)
	for i, v  := range arr1{
		_ = i
		if  v < 48 || v > 57{
			outArr = append(outArr, v)
		}
	}

	return outArr
}

func write(outArr []byte){
	fmt.Println("Enter File Name")
	var fileName string
	fmt.Scanln(&fileName)
	outputFile, err := os.Create(fileName + ".txt")
	check(err)
	defer outputFile.Close()
	_, err = outputFile.Write(outArr)
}
