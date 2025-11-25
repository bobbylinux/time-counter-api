create database time_counter;
create user time_counter with password 'time_counter2025';
create table public.calendars_dates (id bigserial primary key, calendar_date date default current_date);
create type public.mark_types  as enum ('Ingresso','Uscita', 'Spostamento Interno Ingresso', 'Spostamento Interno Uscita');
create table public.calendars_times (id bigserial primary key, calendar_time time not null, calendar_date date not null, mark_type public.mark_types not null);
alter table public.calendars_times
    add constraint calendars_times_fk_calendars_dates
        foreign key (calendar_date) references public.calendars_dates (id);

GRANT CONNECT ON DATABASE time_counter TO time_counter;
GRANT CREATE ON DATABASE time_counter TO time_counter;
GRANT USAGE, CREATE ON SCHEMA time_counter.public TO time_counter;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO time_counter;
ALTER DEFAULT PRIVILEGES IN SCHEMA time_counter.public
    GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO time_counter;
GRANT USAGE, SELECT, UPDATE ON ALL SEQUENCES IN SCHEMA public TO time_counter;
ALTER DEFAULT PRIVILEGES IN SCHEMA public
    GRANT USAGE, SELECT, UPDATE ON SEQUENCES TO time_counter;
GRANT EXECUTE ON ALL FUNCTIONS IN SCHEMA public TO time_counter;
ALTER DEFAULT PRIVILEGES IN SCHEMA public
    GRANT EXECUTE ON FUNCTIONS TO time_counter;
