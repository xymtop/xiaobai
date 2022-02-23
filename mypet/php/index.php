<?php


/* --------------------------------
1  打开消息弹窗
2  打开链接
3打开消息框
4 复制小白
5 播放消息
6 播放远程消息
7 运行cmd
*/

class XiaoBai
{
    //返回数据
    public static function Response($type, $content)
    {
        echo (json_encode([
            'type' => $type,
            'content' => $content
        ]));
    }
}
