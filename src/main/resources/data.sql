INSERT INTO MstGroupMenu (CreatedBy, CreatedDate, ID, ModifiedBy, ModifiedDate, Nama, Deskripsi) VALUES
    (N'1', N'2025-05-21 20:45:57.000000', N'1', NULL, NULL, N'User Management', N'Untuk User Management');

INSERT INTO MstGroupMenu (CreatedBy, CreatedDate, ID, ModifiedBy, ModifiedDate, Nama, Deskripsi) VALUES
    (N'1', N'2025-05-21 20:46:18.000000', N'2', NULL, NULL, N'Artikel', N'Untuk Artikel aneh aneh');

INSERT INTO MstGroupMenu (CreatedBy, CreatedDate, ID, ModifiedBy, ModifiedDate, Nama, Deskripsi) VALUES
    (N'1', N'2025-05-21 20:46:18.000000', N'3', NULL, NULL, N'Buat Delete', N'Buat Delete Doank Sih ....');

INSERT INTO MstMenu (CreatedBy, CreatedDate, ID, IDGroupMenu, ModifiedBy, ModifiedDate, Nama, Path, Deskripsi) VALUES
    (N'1', N'2025-05-21 20:46:18.000000', N'1', N'1', NULL, NULL, N'Group-Menu', N'/group-menu', N'Untuk Menu Konfigurasi Group Menu');

INSERT INTO MstMenu (CreatedBy, CreatedDate, ID, IDGroupMenu, ModifiedBy, ModifiedDate, Nama, Path, Deskripsi) VALUES
    (N'1', N'2025-05-21 20:46:18.000000', N'2', N'1', NULL, NULL, N'Menu', N'/menu', N'Untuk Menu Konfigurasi Menu');

INSERT INTO MstMenu (CreatedBy, CreatedDate, ID, IDGroupMenu, ModifiedBy, ModifiedDate, Nama, Path, Deskripsi) VALUES
    (N'1', N'2025-05-21 20:46:18.000000', N'3', N'1', NULL, NULL, N'Akses', N'/akses', N'Untuk Menu Konfigurasi Akses');

INSERT INTO MstMenu (CreatedBy, CreatedDate, ID, IDGroupMenu, ModifiedBy, ModifiedDate, Nama, Path, Deskripsi) VALUES
    (N'1', N'2025-05-21 20:46:18.000000', N'4', N'1', NULL, NULL, N'User', N'/user', N'Untuk Menu Konfigurasi User');

INSERT INTO MstMenu (CreatedBy, CreatedDate, ID, IDGroupMenu, ModifiedBy, ModifiedDate, Nama, Path, Deskripsi) VALUES
    (N'1', N'2025-05-21 20:46:18.000000', N'5', N'2', NULL, NULL, N'Artikel-1', N'/artikel-1', N'Untuk Konfigurasi Artikel 1');

INSERT INTO MstMenu (CreatedBy, CreatedDate, ID, IDGroupMenu, ModifiedBy, ModifiedDate, Nama, Path, Deskripsi) VALUES
    (N'1', N'2025-05-21 20:46:18.000000', N'6', N'2', NULL, NULL, N'Artikel-2', N'/artikel-2', N'Untuk Konfigurasi Artikel 2');

INSERT INTO MstMenu (CreatedBy, CreatedDate, ID, IDGroupMenu, ModifiedBy, ModifiedDate, Nama, Path, Deskripsi) VALUES
    (N'1', N'2025-05-21 20:46:18.000000', N'7', N'2', NULL, NULL, N'Artikel-3', N'/artikel-3', N'Untuk Konfigurasi Artikel 3');

INSERT INTO MstAkses (CreatedBy, CreatedDate, ID, ModifiedBy, ModifiedDate, Nama, Deskripsi) VALUES
    (N'1', N'2025-05-21 20:46:18.000000', N'1', NULL, NULL, N'Admin', N'Untuk Administrator atau Super User');

INSERT INTO MstAkses (CreatedBy, CreatedDate, ID, ModifiedBy, ModifiedDate, Nama, Deskripsi) VALUES
    (N'1', N'2025-05-21 20:46:18.000000', N'2', NULL, NULL, N'Member', N'Untuk Member Setelah Registrasi');

INSERT INTO MstAkses (CreatedBy, CreatedDate, ID, ModifiedBy, ModifiedDate, Nama, Deskripsi) VALUES
    (N'1', N'2025-05-21 20:46:18.000000', N'3', NULL, NULL, N'Member Test', N'Untuk Member Setelah Registrasi Testing aja');

INSERT INTO MapAksesMenu (IDAkses, IDMenu) VALUES (N'1', N'1');

INSERT INTO MapAksesMenu (IDAkses, IDMenu) VALUES (N'1', N'2');

INSERT INTO MapAksesMenu (IDAkses, IDMenu) VALUES (N'1', N'3');

INSERT INTO MapAksesMenu (IDAkses, IDMenu) VALUES (N'1', N'4');

INSERT INTO MapAksesMenu (IDAkses, IDMenu) VALUES (N'1', N'5');

INSERT INTO MapAksesMenu (IDAkses, IDMenu) VALUES (N'1', N'6');

INSERT INTO MapAksesMenu (IDAkses, IDMenu) VALUES (N'2', N'5');

INSERT INTO MapAksesMenu (IDAkses, IDMenu) VALUES (N'2', N'6');

INSERT INTO MstUser (IsRegistered, TanggalLahir, CreatedBy, CreatedDate, ID, IDAkses, ModifiedBy, ModifiedDate, Username, NoHp, OTP, Password, TokenEstafet, NamaLengkap, Email, LinkImage, PathImage, Alamat)
VALUES (N'1', N'1995-12-12', N'1', N'2025-05-21 21:03:38.464776', N'1', N'1', N'1', N'2025-05-21 21:03:46.874860', N'paul.123', N'081213141321', N'888890', N'$2a$11$WGf7TWx9qZ74TGXdolGFROkuZJqrtil/8ryVy5cLXkfHfZvEbrN6.', NULL, N'Paul Malau', N'poll.chihuy@gmail.com', NULL, NULL, N'Bogor Bogor Bogor Bogor Bogor ');

INSERT INTO MstUser (IsRegistered, TanggalLahir, CreatedBy, CreatedDate, ID, IDAkses, ModifiedBy, ModifiedDate, Username, NoHp, OTP, Password, TokenEstafet, NamaLengkap, Email, LinkImage, PathImage, Alamat) VALUES
    (N'1', N'2001-02-28', N'1', N'2025-05-21 21:03:38.464776', N'2', N'2', N'1', N'2025-05-21 21:03:46.874860', N'kurtcobaan.123', N'08121114132', N'$13$11$WGf7TWx9qZ74TGXdolGFROkuZJqrtil/8ryVy5cLXkfHfZvEN666', N'$13$11$WGf7TWx9qZ74TGXdolGFROkuZJqrtil/8ryVy5cLXkfHfZvEbrN6.', NULL, N'Kurt Cobaan', N'kurt.cobaan@gmail.com', NULL, NULL, N'Jakarta Jakarta Jakarta Jakarta Jakarta Jakarta');
-- ALTER TABLE MstUser ALTER COLUMN ID SET DEFAULT 3;
-- ALTER TABLE MstGroupMenu ALTER COLUMN ID SET DEFAULT 4;
-- ALTER TABLE MstMenu ALTER COLUMN ID SET DEFAULT 8;
-- ALTER TABLE MstAkses ALTER COLUMN ID SET DEFAULT 4;

ALTER TABLE MstGroupMenu ALTER COLUMN ID RESTART WITH 4;
ALTER TABLE MstUser ALTER COLUMN ID RESTART WITH 3;
ALTER TABLE MstMenu ALTER COLUMN ID RESTART WITH 8;
ALTER TABLE MstAkses ALTER COLUMN ID RESTART WITH 4;