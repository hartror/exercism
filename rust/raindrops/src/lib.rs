pub fn raindrops(n: u32) -> String {
    let mut ret = String::from("");
    if n % 3 == 0 {
        ret.push_str("Pling")
    }
    if n % 5 == 0 {
        ret.push_str("Plang")
    }
    if n % 7 == 0 {
        ret.push_str("Plong")
    }
    if ret.len() == 0 {
        ret = n.to_string()
    }
    ret
}
