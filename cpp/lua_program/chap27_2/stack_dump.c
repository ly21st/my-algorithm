#include <stdio.h>
#include <string.h>
#include "lua.h"
#include "lauxlib.h"
#include "lualib.h"

static void stackDump(lua_State *L) {
    int i;
    // 栈的深度
    int top = lua_gettop(L);
    for (i = 1; i <= top; i++) {
        int t = lua_type(L, i);
        switch(t) {
            case LUA_TSTRING: {
                printf("'%s'", lua_tostring(L, i));
                break;
            }
            case LUA_TBOOLEAN: {
                printf(lua_toboolean(L, i)? "true" : "false");
                break;
            }
            case LUA_TNUMBER: {
                if (lua_isinteger(L, i))
                    printf("%lld", lua_tointeger(L, i));
                else
                    printf("%g", lua_tonumber(L, i));
                break;
            }
            default: {
                printf("%s", lua_typename(L, t));
                break;
            }
        }
        printf("  ");
    }
    printf("\n");
}

int main(void) {
    lua_State *L = luaL_newstate();
    
    lua_pushboolean(L, 1);
    lua_pushnumber(L, 10);
    lua_pushnil(L);
    lua_pushstring(L, "hello");
    stackDump(L);

    lua_pushvalue(L, -4);
    stackDump(L);

    lua_replace(L, 3);
    stackDump(L);

    lua_settop(L, 6);
    stackDump(L);

    lua_rotate(L, 3, 1);
    stackDump(L);

    lua_remove(L, -3);
    stackDump(L);

    lua_settop(L, -5);
    stackDump(L);

    lua_close(L);
}
