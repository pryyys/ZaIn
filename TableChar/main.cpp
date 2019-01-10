#include <stdlib.h>
#include <stdio.h>
#include <iostream>
#include <conio.h>
#define MAX_PATH 256

using namespace std;

int main(void) {
    setlocale( LC_ALL,"" );
    char *fileIn = new char[MAX_PATH];
    char *fileOut = new char[MAX_PATH];
    int b[256], j, c;
    int countChar = 0;


    cout << "TableChar" << endl;
    cout << "Enter source filename: \n";
    cin >> fileIn;
    cout << "Enter output filename: \n";
    cin >> fileOut;

    FILE *f=fopen(fileIn, "r");
    FILE *fo=fopen(fileOut, "w");

    if(f==NULL) {
        cout<<"Input file not found \n";
        getch();
    }

    for (j=0; j<256; j++) b[j] = 0;
    while ((c=fgetc(f)) != EOF) {
        if(c>='a' && c<='z') {
                b[c]++;
        }
        else if (c>='A' && c<='Z') {
                b[c]++;
        }
    }

    for (j=65; j<122; j++){
        countChar+=b[j];
    }


    for (j=65; j<90; j++) {
        fprintf(fo,"Letter: %c --- Count: %d --- Percentage: %f%% \n",j,b[j],(float)(b[j]*100)/(float)countChar);
    }

    for (j=97; j<122; j++){
        fprintf(fo,"Letter: %c --- Count: %d --- Percentage: %f%% \n",j,b[j],(float)(b[j]*100)/(float)countChar);
    }

    fprintf(fo, "Total amount of letters: %f \n", (float)countChar);

    fclose(f);
    fclose(fo);
    getch();
 }


