#include <cstdlib>
#include <iostream>
#include <math.h>
using namespace std;

int main(int argc, char *argv[])
{
    int P, A, x1, x2;
    unsigned long long y1, y2, Ya, Yb, k1, k2, z1, z2;
    P = 11;
    A = 7;
    x1 = 3;
    x2 = 8;
    y1 = pow(A,x1);
    y2 = pow(A,x2);
    Ya = y1 % P;
    Yb = y2 % P;
    z1 = pow(Yb,x1);
    z2 = pow(Ya,x2);
    k1 = z1 % P;
    k2 = z2 % P;
    cout<<y1<<endl;
    cout<<y2<<endl;
    cout<<"open key Ya = "<<Ya<<endl;
    cout<<"open key Yb = "<<Yb<<endl;
    cout<<"secret key  = "<<k1<<endl;
    cout<<"secret key  = "<<k2<<endl;


    system("PAUSE");
    return EXIT_SUCCESS;
}
