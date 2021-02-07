create table "Legion"."Type"
(
    id         serial  not null
        constraint "Type_pkey"
            primary key,
    "typeName" varchar not null
        constraint "tNU"
            unique
);

alter table "Legion"."Type"
    owner to "Shimakser";

create table "Legion"."Category"
(
    id             serial  not null
        constraint "Category_pkey"
            primary key,
    "categoryName" varchar not null
        constraint "cNU"
            unique
);

alter table "Legion"."Category"
    owner to "Shimakser";

create table "Legion"."Message"
(
    id           serial  not null
        constraint "Message_pkey"
            primary key,
    "typeId"     integer not null
        constraint "typesIdFk"
            references "Legion"."Type",
    "categoryId" integer not null
        constraint "categIdFk"
            references "Legion"."Category"
);

alter table "Legion"."Message"
    owner to "Shimakser";

