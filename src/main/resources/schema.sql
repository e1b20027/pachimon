CREATE TABLE ptype (
    id IDENTITY,
    typeName VARCHAR NOT NULL
);

CREATE TABLE result(
    p1type VARCHAR NOT NULL,
    p2type VARCHAR NOT NULL,
    p1result VARCHAR NOT NULL,
    p2result VARCHAR NOT NULL
);
