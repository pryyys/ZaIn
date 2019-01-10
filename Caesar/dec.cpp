#include <iostream>
#include <conio.h>
#include <stdio.h>
#include "head.h"

using namespace std;

void decryption() {
    setlocale( LC_ALL,"" );
    char a;
    const int MAX_PATH = 256; // Константа, содержащая максимальную длину имени.
    char *fileIn = new char[MAX_PATH]; // Строка для хранения имени файла ввода.
    char *fileOut = new char[MAX_PATH]; // Строка для хранения имени файла вывода.

    cout<<"Decryption"<<endl;
    cout<<"Enter input filename: \n";
    cin>>fileIn;
    cout<<"Enter output filename: \n";
    cin>>fileOut;

 FILE *f=fopen(fileIn, "r");
 FILE *fo=fopen(fileOut, "w");
 int n;

 if(f==NULL)
 {
    cout<<"Input file not found \n";
    getch();
 } else {
    cout << "Enter shift: \n";
    cin >> n;

    while((a=fgetc(f)) != EOF) {
        if(a>='a' && a<='z') {
            a = (a - (n%26));
                if (a < 'a') a += 26;
                    fprintf(fo, "%c", a);
        }
        else if (a>='A' && a<='Z') {
            a = (a -(n%26));
                if (a < 'A') a += 26;
                    fprintf(fo, "%c", a);
        }
        else {
          fprintf(fo,"%c", a);
      }
  }
    cout<<"Decryption successful \n";
    cout<<"Press Enter to exit \n";
    fclose(f);
    fclose(fo);
    getch();
 }
}
