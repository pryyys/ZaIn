#include <iostream>
#include <conio.h>
#include <stdio.h>
#include <cstdlib>
#include "head.h"

using namespace std;


int main(){
setlocale( LC_ALL,"" );
int ans;
cout << "1 - Encryption, 0 - Decryption \n";
cin >> ans;
if (ans==1) {
    system("cls");
    encryption();
     } else if (ans==0) {
         system("cls");
         decryption();
          } else {
        printf("Error!");
        printf("You either have to input 1 or 0!");
        getch();
        }
}
