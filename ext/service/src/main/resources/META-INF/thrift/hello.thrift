namespace java com.winwill.thrift

enum HellloType {
    SAY_HELLO,   //问好
    QUERY_TIME,  //询问时间
}

struct Person {
    1: required HellloType type;  // 请求的类型，必选
    2: required string name;       // 发起请求的人的名字，必选
    3: optional i32 age;           // 发起请求的人的年龄，可选
    4: optional string gender;  //性别
}

exception HelloException {
    1: required i32 code;
    2: optional string reason;
}

// 服务名
service HelloWordService {
    string sayHello(1: Person person) throws (1:HelloException he); // 可能抛出异常。
}