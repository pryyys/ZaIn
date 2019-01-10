#include <iostream>
#include <conio.h>
#include <stdio.h>
#include "head.h"

using namespace std;

void encryption() {
    setlocale( LC_ALL,"" );
    char a;
    const int MAX_PATH = 256;
    char *fileIn = new char[MAX_PATH];
    char *fileOut = new char[MAX_PATH];

    cout<<"Encryption"<<endl;
    cout<<"Enter input filename: \n";
    cin>>fileIn;
    cout<<"Enter output filename: \n";
    cin>>fileOut;

 FILE *f=fopen(fileIn, "r");
 FILE *fo=fopen(fileOut, "w");
 int n;

    if(f==NULL) {
        cout<<"Input file not found \n";
        getch();
    }
    else {
        cout << "Enter shift: \n";
        cin >> n;

    while((a=fgetc(f)) != EOF) {
        if(a>='a' && a<='z') {
            a = (a + (n%26));
                if (a > 'z') a -= 26;
                    fprintf(fo, "%c", a);
        }
        else if (a>='A' && a<='Z') {
            a = (a + (n%26));
                if (a > 'Z') a -= 26;
                    fprintf(fo, "%c", a);
        }
        else {
            fprintf(fo,"%c", a);
        }
  }
    cout<<"Encryption successful \n";
    cout<<"Press Enter to exit \n";
    fclose(f);
    fclose(fo);
    getch();
 }
}
