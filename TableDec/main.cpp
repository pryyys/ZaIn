#include <stdlib.h>
#include <stdio.h>
#include <iostream>
#include <conio.h>
#define MAX_PATH 256

using namespace std;

int main()
{
    setlocale( LC_ALL,"" );
    char *fileIn = new char[MAX_PATH];
    char *fileDec = new char[MAX_PATH];
    char *fileOut = new char[MAX_PATH];

    int source[256], decr[256], sortin[256], sortdec[256], max, i, ind, c, j;

    cout << "TableChar" << endl;
    cout << "Enter source filename: \n";
    cin >> fileIn;
    cout << "Enter decrypted filename: \n";
    cin >> fileDec;
    cout << "Enter output filename: \n";
    cin >> fileOut;

    FILE *f=fopen(fileIn, "r");
    FILE *fd=fopen(fileDec, "r");
    FILE *fo=fopen(fileOut, "w");

///////////////////////////////////////////////////////

    for (j=0; j<256; j++) source[j] = 0;
    while ((c=fgetc(f)) != EOF) {
        if(c>='a' && c<='z') {
                source[c]++;
        }
        else if (c>='A' && c<='Z') {
                source[c]++;
        }
    }

    for (j=0; j<256; j++) decr[j] = 0;
    while ((c=fgetc(fd)) != EOF) {
        if(c>='a' && c<='z') {
                decr[c]++;
        }
        else if (c>='A' && c<='Z') {
                decr[c]++;
        }
    }

///////////////////////////////////////////////////////

    for (j=0; j<256; j++){
        sortin[j]=0; max=0; ind=0;
            for (i=0; i<256; i++) {
            if (source[i]>max){
                max=source[i]; ind=i;
            }
        }
        sortin[j]=ind;
        source[ind]=0;
    }


    for (j=0; j<256; j++){
        sortdec[j]=0; max=0; ind=0;
            for (i=0; i<256; i++) {
            if (decr[i]>max){
                max=decr[i]; ind=i;
            }
        }
        sortdec[j]=ind;
        decr[ind]=0;
    }

///////////////////////////////////////////////////////

    for (int i=0; i<256; i++) {
        table[i] = i;
    }
    while (1) {
        int m1 = get_index_of_max(stats1);
        int m2 = get_index_of_max(stats2);
        if ((m1>-1) && (m2>-1)) {
            table[m1] = m2;
        } else {
            break;
        }
    }
}

///////////////////////////////////////////////////////

int s;
c = 0;
fd = fopen("enc1.txt", "r");

    while ((c=fgetc(fd))!=EOF){
        for (i=0; i<256; i++){
            if (sortdec[i]=c) {
                s=sortin[i];
            }
        }
        fprintf (fo,"%c",s);
    }



    fclose(f);
    fclose(fd);
    fclose(fo);
    getch();
    return 0;
}
