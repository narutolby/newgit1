package google.usefullquestion;String toTranslate = “{Welcome} to Google. Say {Hi}”

some words are placeholders
placeholders = “Welcome”, “Hi”

placeholder = “{“, value, “}”

nested braces are not allowed, unless they’re escaped with a back-slash
valid
“{Welcome}”
“{\{Welcome}”
“{\{Welcome}\}”   => “{Welcome”

invalid
“Welcome}”
“{{Welcome}”
“{{Welcome}}”

Given an input that contains placeholders, return the list of placeholders

you should handle the invalid cases and either (1) throw an exception, or (2) return an error code.

it’s common to handle errors and exceptional cases.
bad input

    
idea：用stack去做，这题没说明白，
    两种情况， 1，如果 \的作用是去掉前面的{，那么用stack时直接pop出来，不需要存\
             2,如果 \的作用是去掉后面的{,那么用stack时加入\，然后如果{出现在后面的，就pop\
                 最后判断stack是否为空，找好stack与{} \的关系就行，不难