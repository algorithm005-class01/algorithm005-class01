#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main()
{

    vector<string> msg {"Hello", "C++", "World", "from", "VS Code!"};
    int a;
    cin >> a;
    for (const string& word : msg)
    {
        cout << word << " "<<endl;
    }
    cout << endl;
}
